package com.example.formula1tfc.controller;


import com.example.formula1tfc.dto.CreateUserDTO;
import com.example.formula1tfc.dto.UsuarioDTO;
import com.example.formula1tfc.error.GeneralError;
import com.example.formula1tfc.error.UsuarioNameNotFoundException;
import com.example.formula1tfc.error.UsuarioNotFoundException;
import com.example.formula1tfc.mapper.UsuarioMapper;
import com.example.formula1tfc.models.Login;
import com.example.formula1tfc.models.UserRole;
import com.example.formula1tfc.models.Usuario;
import com.example.formula1tfc.repository.LoginRepository;
import com.example.formula1tfc.repository.UsuarioRepository;
import com.example.formula1tfc.security.jwt.JwtProvider;
import com.example.formula1tfc.security.jwt.model.JwtUserResponse;
import com.example.formula1tfc.security.jwt.model.LoginRequest;
import com.example.formula1tfc.service.uploads.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider tokenProvider;
    private final LoginRepository loginRepository;


    @GetMapping(value = "/all2")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioMapper.toDTO(usuarioRepository.findAll()));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDTO>> findAll(@RequestParam(required = false, name = "limit") Optional<String> limit,
                                                    @RequestParam(required = false, name = "nombre") Optional<String> nombre) {
        List<Usuario> usuarios = null;
        try {
            if (nombre.isPresent()) {
                //usuarios = usuarioRepository.findByNombreContainsIgnoreCase(nombre.get());
            } else {
                usuarios = usuarioRepository.findAll();
            }
            if (limit.isPresent() && !usuarios.isEmpty() && usuarios.size() > Integer.parseInt(limit.get())) {

                return ResponseEntity.ok(usuarioMapper.toDTO(
                        usuarios.subList(0, Integer.parseInt(limit.get())))
                );
            } else {
                if (!usuarios.isEmpty()) {
                    return ResponseEntity.ok(usuarioMapper.toDTO(usuarios));
                } else {
                    throw new Exception(); //Excepcion personalizada
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(); //excepcion personalizada
        }
    }

    @ApiOperation(value = "Obtener un usuario por id", notes = "Obtiene un usuario por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UsuarioDTO.class),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
        return ResponseEntity.status(HttpStatus.OK).body(usuarioMapper.toDTO(usuario));

    }
    @GetMapping("/name/{username}")
    public UsuarioDTO obtenerUsuarioPorNombre(@PathVariable String username){
        Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow(() -> new UsuarioNameNotFoundException(username));
        return usuarioMapper.toDTO(usuario);
    }
    //Crear usuario seguro
    @ApiOperation(value = "Crear un usuario", notes = "Crea un usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Created", response = CreateUserDTO.class),
            @ApiResponse(code = 400, message = "Bad Request") //Excepcion personalizada
    })
    @PostMapping("/save")
    public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioDTO nuevoUsuario) throws Exception {
        Usuario usuario = usuarioMapper.fromDTO(nuevoUsuario);
        checkUsuarioData(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioMapper.toDTO(usuarioService.saveUsuario(nuevoUsuario)));
    }
    @PostMapping("/login")
    public JwtUserResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword()
                        )
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Usuario user = (Usuario) authentication.getPrincipal();
        String jwtToken = tokenProvider.generateToken(authentication);
        Login login = new Login(jwtToken, user);
        loginRepository.save(login);
        return convertUserEntityAndTokenToJwtUserResponse(user, jwtToken);
    }

    @ApiOperation(value = "Actualizar un usuario", notes = "Actualiza un usuario por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UsuarioDTO.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<UsuarioDTO> update( @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioMapper.toDTO(usuarioRepository.save(usuario)));
    }


    @ApiOperation(value = "Eliminar un usuario", notes = "Elimina un usuario dado su id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UsuarioDTO.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        usuarioRepository.deleteById(id);
        Optional<Usuario> cliente = usuarioRepository.findById(id);
        if (cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        }
    }


    /**
     * Método para comprobar que los datos del usuario son correctos
     *
     * @param usuario Usuario a comprobar
     *                - nombre no puede estar vacía
     *                - salario no puede estar vacío
     */
    private void checkUsuarioData(Usuario usuario) {
        if (usuario.getUsername() == null || usuario.getUsername().isEmpty()) {
            throw new RuntimeException("El nombre es obligatorio");
        }
    }

    @ApiOperation(value = "Crea un usuario", notes = "Crea un usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UsuarioDTO.class),
            @ApiResponse(code = 400, message = "Bad Request"),
    })
    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> nuevoUsuario(
            @RequestPart("usuario") UsuarioDTO usuarioDTO) {
        try {
            // Comprobamos los campos obligatorios
            Usuario usuario = usuarioMapper.fromDTO(usuarioDTO);
            checkUsuarioData(usuario);
            //TODO IMAGEN?
            Usuario usuarioInsertado = usuarioRepository.save(usuario);
            return ResponseEntity.ok(usuarioMapper.toDTO(usuarioInsertado));
        } catch (Exception ex) {
            throw new RuntimeException("Insertar, Error al insertar el usuario. Campos incorrectos");
        }
    }

    @ApiOperation(value = "Obtiene una lista de usuarios", notes = "Obtiene una lista de usuarios paginada, filtrada y ordenada")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK: Lista de usuarios", response = UsuarioDTO.class),
            @ApiResponse(code = 400, message = "Bad Request: Lista no encontrada")
    })
    @GetMapping("/all/usuarios")
    public ResponseEntity<?> listado(
            // Podemos buscar por los campos que queramos... nombre, precio... así construir consultas
            @RequestParam(required = false, name = "nombre") Optional<String> nombre,
            @RequestParam(required = false, name = "dni") Optional<String> dni,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort
    ) {
        // Consulto en base a las páginas
        Pageable paging = PageRequest.of(page, size, Sort.Direction.ASC, sort);
        Page<Usuario> pagedResult;
        try {
            if (nombre.isPresent() && dni.isPresent()) {
                pagedResult = usuarioRepository.findAll(paging);
            } else {
                throw new RuntimeException("Hay algún campo incompleto: matricula o salario");
            }
            // De la página saco la lista de usuarios
            //List<Usuario> usuarios = pagedResult.getContent();
            // Mapeo al DTO. Si quieres ver toda la info de las paginas pon pageResult.


            /*ListUsuarioPageDTO listUsuarioPageDTO = ListUsuarioPageDTO.builder()
                    .data(usuarioMapper.toDTO(pagedResult.getContent()))
                    .totalPages(pagedResult.getTotalPages())
                    .totalElements(pagedResult.getTotalElements())
                    .currentPage(pagedResult.getNumber())
                    .sort(pagedResult.getSort().toString())
                    .build();
            return ResponseEntity.ok(listUsuarioPageDTO);*/
            return null; //<-------------Cambiar esto por el bloque comentado
        } catch (Exception e) {
            throw new RuntimeException("Selección de Datos Parámetros de consulta incorrectos");
        }
    }
    private JwtUserResponse convertUserEntityAndTokenToJwtUserResponse(Usuario user, String jwtToken) {
        return JwtUserResponse
                .jwtUserResponseBuilder()
                .id(user.getId())
                .username(user.getUsername())
                .roles(user.getRoles().stream().map(UserRole::name).collect(Collectors.toSet()))
                .correo(user.getCorreo())
                .imagen(user.getImagen())
                .password(user.getPassword())
                .token(jwtToken)
                .build();
    }

}