package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UpdateMatchDate {

    public static void main(String[] args) {
        String propertiesFilePath = "BD.Properties";
        String dateFormat = "yyyy-MM-dd";
        int monthsToSubtractCreateAt = 5;
        int daysToSubtractNetDate = 2;
        int daysToSubtractTotalDate = 4;

        // Obtener la fecha actual
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // Restar el número de meses para create_at
        calendar.add(Calendar.MONTH, -monthsToSubtractCreateAt);
        Date createAtDate = calendar.getTime();

        // Restar el número de días para net_date
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, -daysToSubtractNetDate);
        Date netDate = calendar.getTime();

        // Restar el número de días para total_date
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, -daysToSubtractTotalDate);
        Date totalDate = calendar.getTime();

        // Formatear las nuevas fechas
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String newCreateAt = sdf.format(createAtDate);
        String newNetDate = sdf.format(netDate);
        String newTotalDate = sdf.format(totalDate);

        // Actualizar el archivo BD.Properties
        updatePropertiesFile(propertiesFilePath, newCreateAt, newNetDate, newTotalDate);
    }

    private static void updatePropertiesFile(String filePath, String newCreateAt, String newNetDate, String newTotalDate) {
        try {
            // Leer el archivo original
            List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);

            // Buscar la línea que contiene el campo "obligation"
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.startsWith("obligation=")) {
                    // Reemplazar la línea con los nuevos valores
                    line = "obligation=UPDATE matches SET valor = 10000, create_at='" + newCreateAt +
                            "', net_date='" + newNetDate + "', total_date='" + newTotalDate + "' WHERE id = 12345";
                    lines.set(i, line);
                    break;
                }
            }

            // Escribir las líneas actualizadas en el archivo
            Files.write(Paths.get(filePath), lines, StandardCharsets.UTF_8);

            System.out.println("Los campos create_at, net_date y total_date se han actualizado con éxito en el archivo " + filePath);
        } catch (IOException e) {
            System.out.println("Error al actualizar los campos create_at, net_date y total_date en el archivo " + filePath);
            e.printStackTrace();
        }
    }
}

