public class AnalizadorTareas {
    private Tarea[] tareas;

    public AnalizadorTareas(Tarea[] tareas) {
        this.tareas = tareas;
    }

    public int contarCompletadas() {
        if (tareas == null) {
            return 0;
        }
        int contador = 0;
        for (Tarea t : tareas) {
            if (t != null && t.isCompletada()) {
                contador++;
            }
        }
        return contador;
    }

    public int calcularHorasTotales() {
        if (tareas == null) {
            return 0;
        }
        int totalHoras = 0;
        for (Tarea t : tareas) {
            if (t != null) {
                totalHoras += t.getHorasEstimadas();
            }
        }
        return totalHoras;
    }

    public String buscarPorCodigo(String codigoBuscado) {
        if (tareas == null || codigoBuscado == null) {
            return "No se encontró ninguna tarea con el código: " + codigoBuscado;
        }
        for (Tarea t : tareas) {
            if (t != null && t.getCodigo() != null && t.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                return t.describir();
            }
        }
        return "No se encontró ninguna tarea con el código: \"" + codigoBuscado + "\".";
    }

    public Tarea obtenerTareaMayorDuracion() {
        if (tareas == null || tareas.length == 0) {
            return null;
        }
        Tarea mayor = null;
        for (Tarea t : tareas) {
            if (t != null) {
                if (mayor == null || t.getHorasEstimadas() > mayor.getHorasEstimadas()) {
                    mayor = t;
                }
            }
        }
        return mayor;
    }
}