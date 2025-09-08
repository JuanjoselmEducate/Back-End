package co.edu.ue.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.ue.entity.Categoria;
import co.edu.ue.entity.Gasto;
import co.edu.ue.entity.Usuario;
import co.edu.ue.repository.CategoriaRepository;
import co.edu.ue.repository.GastoRepository;      // <-- este es el de Spring Data JPA (JpaRepository<Gasto, Integer>)
import co.edu.ue.repository.UsuarioRepository;    // <-- este es tu wrapper con readUsuario(...), NO lo cambiamos

@Service
public class GastoService {

    private final GastoRepository gastoRepo;
    private final UsuarioRepository usuarioRepo;      // wrapper
    private final CategoriaRepository categoriaRepo;  // wrapper

    public GastoService(
            GastoRepository gastoRepo,
            UsuarioRepository usuarioRepo,
            CategoriaRepository categoriaRepo) {
        this.gastoRepo = gastoRepo;
        this.usuarioRepo = usuarioRepo;
        this.categoriaRepo = categoriaRepo;
    }

    /* ===== CRUD ===== */

    public List<Gasto> listar() {
        return gastoRepo.findAll();
    }

    public Gasto obtener(int id) {
        return gastoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado con id: " + id));
    }

    public Gasto crear(Gasto gasto, int userId, int categoriaId) {

        Usuario usuario = usuarioRepo.readUsuario(userId);
        if (usuario == null) throw new RuntimeException("Usuario no encontrado");

        Categoria categoria = categoriaRepo.readCategoria(categoriaId);
        if (categoria == null) throw new RuntimeException("Categoria no encontrada");

        gasto.setUsuario(usuario);
        gasto.setCategoria(categoria);
        gasto.setCreado(new java.sql.Timestamp(System.currentTimeMillis()));

        return gastoRepo.save(gasto);
    }

    public Gasto actualizar(int id, Gasto datos, int userId, int categoriaId) {
        Gasto gasto = obtener(id);

        gasto.setDescripcion(datos.getDescripcion());
        gasto.setMonto(datos.getMonto());
        gasto.setFechaGasto(datos.getFechaGasto());
        gasto.setTipoGasto(datos.getTipoGasto());
        gasto.setNotas(datos.getNotas());

        Usuario usuario = usuarioRepo.readUsuario(userId);
        if (usuario == null) throw new RuntimeException("Usuario no encontrado");
        Categoria categoria = categoriaRepo.readCategoria(categoriaId);
        if (categoria == null) throw new RuntimeException("Categoria no encontrada");

        gasto.setUsuario(usuario);
        gasto.setCategoria(categoria);

        return gastoRepo.save(gasto);
    }

    public void eliminar(int id) {
        gastoRepo.deleteById(id);
    }


    public List<Gasto> porUsuario(int userId) {
        return gastoRepo.findByUsuarioId(userId);
    }

    public List<Gasto> porCategoria(int categoriaId) {
        return gastoRepo.findByCategoriaId(categoriaId);
    }

    public List<Gasto> porTipo(String tipo) {
        return gastoRepo.findByTipoGastoIgnoreCase(tipo);
    }

    public List<Gasto> porRango(Date inicio, Date fin) {
        return gastoRepo.findByFechaGastoBetween(inicio, fin);
    }
}
