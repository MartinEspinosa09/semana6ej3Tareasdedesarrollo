public class Main {
    public static void main(String[] args) {
        // Crear 6 tareas
        Tarea t1 = new Tarea("TSK-01", "Diseñar base de datos", 6, true);
        Tarea t2 = new Tarea("TSK-02", "Implementar login JWT", 10, false);
        Tarea t3 = new Tarea("TSK-03", "Crear endpoints REST", 14, false);
        Tarea t4 = new Tarea("TSK-04", "Configurar despliegue CI/CD", 5, true);
        Tarea t5 = new Tarea("TSK-05", "Pruebas unitarias de servicios", 8, false);
        Tarea t6 = new Tarea("TSK-06", "Documentación técnica API", 4, false);

        // Marcar alguna como completada usando el setter permitido
        t5.setCompletada(true);

        Tarea[] arregloTareas = { t1, t2, t3, t4, t5, t6 };
        AnalizadorTareas analizador = new AnalizadorTareas(arregloTareas);

        // 1. Conteo de completadas
        System.out.println("=== 1. CONTEO DE TAREAS COMPLETADAS ===");
        System.out.println("Tareas completadas: " + analizador.contarCompletadas());

        // 2. Horas totales
        System.out.println("\n=== 2. HORAS TOTALES ESTIMADAS ===");
        System.out.println("Total de horas del sprint: " + analizador.calcularHorasTotales() + " h");

        // 3. Búsquedas (existente e inexistente)
        System.out.println("\n=== 3. BUSCAR TAREA EXISTENTE ===");
        System.out.println(analizador.buscarPorCodigo("TSK-02"));

        System.out.println("\n=== 4. BUSCAR TAREA INEXISTENTE ===");
        System.out.println(analizador.buscarPorCodigo("TSK-99"));

        // 4. Tarea de mayor duración
        System.out.println("\n=== 5. TAREA DE MAYOR DURACIÓN ===");
        Tarea tareaMaxima = analizador.obtenerTareaMayorDuracion();
        if (tareaMaxima != null) {
            System.out.println(tareaMaxima.describir());
        } else {
            System.out.println("No hay tareas registradas.");
        }
    }
}