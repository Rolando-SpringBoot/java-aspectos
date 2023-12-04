## Aspect oriented Programming COre Concepts
* Aspect: un aspecto es una clase que implementa aspectos de aplicaciones empresariales que abarcan
  varias clases, como la gestión de transacciones. Los aspectos pueden ser una clase normal configurada
  a través de la configuración Spring XML o podemos usar la integración Spring AspectJ para definir una
  clase como aspecto usando @Aspect anotaciones.
* Join Point: Un Join Point es un punto específico en la aplicación, como la ejecución de métodos,
  manejo de excepciones, cambio de valores de variables de objetos, etc. En Spring AOP, un Join Point
  es siempre la ejecución de un método.
* Pointcut: Son expresiones que coinciden con JoinPoint para determinar si es necesario ejecutar
  el advice o no. Pointcut usa diferentes tipos de expresiones que coinciden con los JoinPoint y
  Spring Framework usa el lenguaje donde se anula el método de destino y se incluyen advices según
  su configuración.
  Pointcut tiene diferentes formas de ser definido: `within`, `annotation`, `execution`, `args`, 
  `target`, `this`.
* Advice: Advices son acciones tomadas para un JoinPoint en específico. En términos de programación,
  son métodos que se ejecutan cuando se alcanza un determinado JoinPoint con un Pointcut coincidente
  en la aplicación.
* Target Object: Son el objeto sobre el que se aplican los advices. Spring AOP se implementa mediante
  servidores proxy en tiempo de ejecución, por lo que este objeto es siempre un objeto proxy.
  Lo que esto significa es que se crea una subclase en tiempo de ejecución donde se anula el método
  de destino y se incluyen advices según configuración.
* AOP Proxy: La implementación de Spring AOP utiliza el proxy dinámico JDK para crear las
  clases de Proxy con clases de destino e invocaciones de advices, estas se denominan clases de
  proxy AOP. También podemos usar el proxy CGLIB agregándolo como dependencia en el proyecto
  Spring AOP.
* Weaving: Es el proceso de vincular aspectos con otros objetos para crear los objetos proxy
  recomendados. Esto se puede hacer en tiempo de compilación, tiempo de carga o en tiempo
  de ejecución. Spring AOP realiza weaving (tejido) en tiempo de ejecución.

## AOP Advice Types
* Before advice: Estos advices se ejecutan antes de la ejecución de los JoinPoint métodos.
  Podemos usar `@Before` anotación para marcar un tipo de advice como **Before advice**
* After (finally) Advice: Un advice que se ejecuta después de que el JoinPoint método
  termine de ejecutarse, ya sea normalmente o lanzando una excepción.
  Podemos crear **After advice** usando `@After` anotación.
* After Returning Advice: A veces queremos que los advice métodos se ejecuten solo si el JoinPoint
  método se ejecuta normalmente. Podemos usar `@AfterReturning` anotaciones para marcar
  un método como **After returning advice**.
* After Throwing Advice: Este consejo se ejecuta solo cuando JoinPoint método lanza una excepción.
  Nosotros podemos usarlo para revertir la transacción de forma declarativa. Usamos `@AfterThrowing`
  anotaciones para este tipo de advice.
* Around device: Este es el advice más importante y poderoso. Este advice rodea JoinPoint método
  y nosotros también podemos elegir si ejecutar el JoinPoint método o no. Podemos escribir código
  de advice que se ejecute antes y después de la ejecución del JoinPoint método. Es responsabilidad
  del **around advice** invocar el JoinPoint método y devolver valores si el método devuelve algo.
  Usamos `@Around` anotación para crear Around métodos.