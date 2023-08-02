# Workshop: Programación Funcional Java 8
En este taller veremos las diferencias entre la programacion funcional y la tradicional, podremos ver sus ventajas y como es que se realiza su implementación en Java 8.

## ¿Qué es la Programación Funcional?
La programación funcional es un paradigma de programación declarativo en la que su principal forma de trabajar es mediante el uso de funciones.
Este paradigma de programación se enfoca en el “que” estamos haciendo (declarativo) y no en el “como” lo estamos haciendo (imperativo).

## Programación Declarativa vs Imperativa
Como se mencionó en la diapositiva anterior existe una gran diferencia entre la programación declarativa y la imperativa, puesto que la programación declarativa está enfocada en el “que” es lo que vamos a realizar, por otro lado, en la programación imperativa se busca el “como” vamos a resolver la problemática.

## Ventajas de la Programación Funcional
- Permite que el código sea más conciso.
- El código se comporta de manera más predecible.
- Permite una mayor facilidad a la hora de realizar pruebas.
- Lo que nos lleva a tener menos bugs.

## Como implementar la Programación Funcional 
Podemos implementar la programación funcional en varios lenguajes de programación, para este workshop nos enfocaremos en Java 8. 
Java tiene una serie de características embebidas que nos permiten implementar la programación funcional, lo más común es hacer uso de stream y funciones lambda.

## Pasemos a la practica
**Ejercicio 1:** Dada una cadena de caracteres, obtener el número de repeticiones de cada letra. Finalmente imprime una lista de manera ordenada por el número de repeticiones.

En este ejercicio lo tendremos en la clase llamada Characters.java, dentro de el tendremos dos metodos que resuelven la problemática, uno usando el paradigma declarativo y otro imperativo.

A continuacion tenemos el metodo imperativo:

```
public static void imperative(String test, Map<Character, Integer> map){
        List<Character> list = convert(test);
        for(int i = 0; i < list.size(); i++){
            if(Character.isLetter(list.get(i))){
                if(!map.containsKey(list.get(i))){
                    map.put(list.get(i), 1);
                } else {
                    map.put(list.get(i), map.get(list.get(i)) + 1);
                }
            }
        }

        System.out.println(map);
    }
```

Por otra parte tenemos el metodo declarativo, que es el que nos interesa abordar en este taller:

```
public static void declarative(String test, Map<Character, Integer> map){
        // Using the Character List, will put every character and initialize the value as 1,
        // then increase the value by 1 if repeats
        convert(test).stream()
                .filter(Character::isLetter)
                .forEach(character -> {
                    if(map.containsKey(character)){
                        map.put(character, map.get(character) + 1);
                    } else {
                        map.put(character, 1);
                    }
                });

        // Print the map
        System.out.println(map);
    }
```

Como podemos observar, es notoria la diferencia ya que de la manera tradicional nos enfocamos mucho en como realizar la tarea, por ende hacemos uso de ciclos y accedemos a atributos y listas.Por otra parte con la manera declarativa solamente nos enfocamos en lo que queremos resolver sin importar el como se este haciendo.


**Ejercicio 2:** Dada una serie de personas y su información, realizar las siguientes de búsquedas:
- Lista los nombres de las personas de Monterrey.
  ```
  // Filter people from Monterrey
        System.out.println("People from Monterrey: ");
        people.stream()
                .filter(person -> person.getCity().equals("Monterrey"))
                .map(Person::getName)
                .forEach(System.out::println);
  ```
- Lista los nombres de las personas menores de 30 años.
  ```
  // Filter people younger than 30
        System.out.println("People younger than 30: ");
        people.stream()
                .filter(person -> person.getAge() < 30)
                .map(Person::getName)
                .forEach(System.out::println);
  ```
- Por último, agrupa todas las personas en grupos separados por su cuidad y muestralos en pantalla.
  ```
  // Get just the names of the people and then group it by City
        System.out.println("Grouping: ");
        System.out.println(people.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.mapping(Person::getName, Collectors.toList()))));
  ```

Para cada uno de los puntos tuvimos un metodo que nos ayudara a realizar la accion, cada uno de ellos esta programado de manera declarativa, por ende estaremos enfocados en la resolucion del problema y no en como lo vamos a resolver. Por otro lado tendriamos la programacion imperativa que tambien nos permite resolver la problematica pero con un enfoque distinto.


















