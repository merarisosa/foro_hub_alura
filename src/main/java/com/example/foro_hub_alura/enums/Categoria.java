package com.example.foro_hub_alura.enums;


public enum Categoria {
    LENGUAJES_DE_PROGRAMACION ("Lenguajes de Programacion"),
    FRAMEWORKS_Y_HERRAMIENTAS ("Frameworks y Herramientas"),
    DESARROLLO_WEB ("Desarrollo Web"),
    DESARROLLO_MOVIL("Desarrollo Movil"),
    CIENCIA_DE_DATOS_Y_ANALISIS("Ciencia de Datos y Analisis"),
    SEGURIDAD_INFORMATICA("Seguridad Informatica"),
    CARRERAS_Y_DESARROLLO_PROFESIONAL("Carreras y Desarrollo Profesional"),
    GENERAL_Y_OFF_TOPIC("General y Off-topic"),
    EVENTOS_Y_CONFERENCIAS("Eventos y Conferencias"),
    RECURSOS_Y_TUTORIALES("Recursos y Tutoriales");

    private final String nombre;

    Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}