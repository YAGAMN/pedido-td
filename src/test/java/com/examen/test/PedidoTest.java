import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void pedidoCorrecto() {
        Pedido p = new Pedido("P123", "Juan", 10, 50.0, LocalDate.now());
        assertEquals("El pedido ha sido registrado correctamente", p.validar());
    }

    @Test
    void codigoInvalido() {
        Pedido p = new Pedido("1234", "Juan", 10, 50.0, LocalDate.now());
        assertEquals("Ingrese un código de pedido válido", p.validar());
    }

    @Test
    void clienteInvalido() {
        Pedido p = new Pedido("P123", "Jo", 10, 50.0, LocalDate.now());
        assertEquals("El nombre del cliente debe tener al menos tres caracteres alfabéticos", p.validar());
    }

    @Test
    void mesaInvalida() {
        Pedido p = new Pedido("P123", "Juan", 60, 50.0, LocalDate.now());
        assertEquals("Ingrese un número de mesa válido", p.validar());
    }

    @Test
    void montoInvalido() {
        Pedido p = new Pedido("P123", "Juan", 10, -50.0, LocalDate.now());
        assertEquals("El monto debe ser mayor a cero", p.validar());
    }

    @Test
    void fechaInvalida() {
        Pedido p = new Pedido("P123", "Juan", 10, 50.0, LocalDate.now().minusDays(1));
        assertEquals("La fecha del pedido debe ser la fecha actual", p.validar());
    }

    @Test
    void camposVacios() {
        Pedido p = new Pedido(null, "Juan", 10, 50.0, LocalDate.now());
        assertEquals("Debe ingresar todos los datos requeridos", p.validar());
    }
}