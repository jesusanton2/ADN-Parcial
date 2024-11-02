## PARCIAL MUTANTES
 Este proyecto es un sistema para detectar si una secuencia de ADN correspone a un humano o mutante.
 Se implemento una busqueda secuencial, por fila columna y las distintas diagonales posibles, en la cual se 
 convierte cada fila, columna o diagonal, a una cadena de caracteres. Se recorre la misma buscando coincidencias 
 contiguas de letras iguales, si no se encuentra una secuencia o encuentra una letra diferente sigue buscando en la 
 misma cadena.

 ##Instalacion / Ejecucion
Para instalar y/o ejecutar el proyecto, sigue estos pasos:

1. **Descarga el proyecto** en formato ZIP (no clonar).
2. Asegúrate de tener instalado **Java** y **Gradle**.
3. **Descomprime** el proyecto en un directorio de tu preferencia.
4. **Abre el proyecto** en un entorno de desarrollo como **Apache NetBeans**, **IntelliJ IDEA**, etc.
5. **Construye el proyecto** (build) ejecutando el comando correspondiente en tu IDE.
6. **Ejecuta** la aplicación.

Después de ejecutar el proyecto, podrás probar las API en Postman o en cualquier herramienta similar.

##APIS 

**Descripción:**  
Esta API permite verificar si una secuencia de ADN corresponde a un mutante. Acepta una matriz de ADN en formato JSON y devuelve un resultado que indica si la secuencia es mutante o no.

**Método:** POST /mutant

**Endpoint:**
- **Local:** `http://localhost:8080/mutant`
- **Producción:** `https://adn-parcial.onrender.com/mutant`

**Ejemplo de solicitud:**

POST /mutant
Content-Type: application/json

{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
    ]
}
Respuesta esperada "El ADN pertenece a un mutante"

**Método:** GET /mutant/stats
**Endpoint:**
- **Local:** `http://localhost:8080/mutant/stats`
- **Producción:** `https://adn-parcial.onrender.com/mutant/stats`
  Ejemplo de respuesta
 {
    "count_human_dna": 1,
    "count_mutant_dna": 2,
    "ratio": 2.0

}

Documento Nivel 3
[Nivel3.pdf](https://github.com/user-attachments/files/17608626/Nivel3.pdf)

