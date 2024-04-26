import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AutolavadoModelo {
    private Queue<Auto> colaEspera;
    private Stack<Auto> autosLavados;

    public AutolavadoModelo() {
        colaEspera = new LinkedList<>();
        autosLavados = new Stack<>();
    }

    public void registrarAuto(Auto auto) {
        colaEspera.add(auto);
    }

    public void lavarAuto() {
        if (!colaEspera.isEmpty()) {
            Auto auto = colaEspera.poll();
            autosLavados.push(auto);
        }
    }

    public Queue<Auto> getColaEspera() {
        return colaEspera;
    }

    public Stack<Auto> getAutosLavados() {
        return autosLavados;
    }
}
