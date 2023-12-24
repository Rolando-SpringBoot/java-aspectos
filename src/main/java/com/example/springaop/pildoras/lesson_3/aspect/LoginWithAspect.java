package com.example.springaop.pildoras.lesson_3.aspect;

import com.example.springaop.pildoras.lesson_3.domain.Client;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 @Order annotation allows you to specify the order of aspect's execution.
 */
@Order(3)
@Aspect
@Component
public class LoginWithAspect {

  /*
    JoinPoint - méthods more used
    getArgs() -  Returns the arguments at this join point.
    getSignature() -  Returns the signature at the join point.
      . getDeclaringType() -  Returns a java.lang.Class object representing the class, interface, or aspect that declared this member.
      . getDeclaringTypeName() - Returns the fully-qualified name of the declaring type.
      . getModifiers() - Returns the modifiers on this signature represented as an int.
      . getName() - Returns the identifier part of this signature.
      . toLongString() - Returns an extended string representation of this signature.
      . toShortString() - Returns an abbreviated string representation of this signature.
    getTarget() - Returns the target object.
    getKind() - Returns a String representing the kind of join point.
   */

  @Pointcut("execution(* com.example.springaop.pildoras.lesson_3.dao.*.*(..))")
  public void toClients() {}

  @Pointcut("execution(java.util.List com.example.springaop..lesson_3.dao.ClientDAO.findAll(..))")
  private void toClientFindAll() {}

  /*
    If you have @Before, @AfterReturning @AfterThrowing, @After and @Around advice
    in the same aspect. The order of execution would be:
    - @Around before to execute method
    - @Before
    - @AfterReturning / @AfterThrowing
    - @After
    - @Around after to execute method
   */

  /*
    Executed before to target method.
    if you want, you can access to arguments method through JoinPoint
   */
  @Before("toClients()")
  public void beforeToSaveClient(JoinPoint joinPoint) {
    // argument method
    Object firstArg = joinPoint.getArgs()[0];
    System.out.println(STR."BEFORE First arg \{firstArg.getClass().getSimpleName()} : \{firstArg}");

    System.out.println("El usuario está registrado");
    System.out.println("El perfil para insertar clientes es correcto");
  }

   /*
    Executed after the target method successfully returns.
    It won't execute if the target method throws an exception.
    If you want, you can access to arguments method through JoinPoint
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @AfterReturning(value = "toClientFindAll()", returning = "result")
  public void taskAfterFindAllClients(JoinPoint joinPoint, Object result) {
    // argument method
    Object firstArg = joinPoint.getArgs()[0];
    System.out.println(STR."AFTER RETURNING First arg \{firstArg.getClass().getSimpleName()} : \{firstArg}");

    List<Client> clientList = new ArrayList<>();
    if(result instanceof List list) {
      clientList = (List<Client>) list.stream()
          .filter(o -> o instanceof Client)
          .toList();
    }
    for(Client client : clientList) {
      if (client.getType().equalsIgnoreCase("vip")) {
        // modifying content
        String dataProcessed = "V:I:P" + client.getName().toUpperCase();
        client.setName(dataProcessed);
        System.out.println(STR."Existen clientes VIP en el listado. Nombre: \{client.getName()}");
      }
    }
  }

  /*
    Executed if the target method throws an exception.
    It won't execute if the target method completes normally.
    If you want, you can access to arguments method through JoinPoint
   */
  @AfterThrowing(value = "toClientFindAll()", throwing = "throwable")
  public void taskAfterThrowingFindAllClients(JoinPoint joinPoint, Throwable throwable) {
    // argument method
    Object firstArg = joinPoint.getArgs()[0];
    System.out.println(STR."AFTER THROWING First arg \{firstArg.getClass().getSimpleName()} : \{firstArg}");

    if(throwable instanceof NullPointerException exception) {
      System.out.println("I am a null pointer exception");
    }
    System.out.println(STR."AFTER THROWING The message error is: \{throwable.getMessage()}");
    System.out.println("Aquí se estarían ejecutando de forma automática las tareas tras excepción");
  }

   /*
   Executed after the target method, regardless of whether it completed normally or threw an exception.
   It acts like a finally block.
    If you want, you can access to arguments method thr JoinPoint
   */
  @After(value = "toClientFindAll()")
  public void taskWithAndWithoutExceptionFindAllClients(JoinPoint joinPoint) {
    // argument method
    Object firstArg = joinPoint.getArgs()[0];
    System.out.println(STR."AFTER First arg \{firstArg.getClass().getSimpleName()} : \{firstArg}");

    System.out.println("Ejecutando tareas SIEMPRE!!!");
  }

  /*
    Executed before and after the target method.
    It has the most control over the target method's invocation.
    Therefore, You can modify the value of target method which will be returned
    at the end. Specially when this target method throws an exception.
   */
  @Around(value = "toClientFindAll()")
  public Object taskAroundFindAllClients(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    Instant beginTime = Instant.now();
    System.out.println("---comienzo de acciones antes de llamada");

    // argument method
    Object firstArg = proceedingJoinPoint.getArgs()[0];
    System.out.println(STR."AROUND First arg \{firstArg.getClass().getSimpleName()} : \{firstArg}");

    Object result;
    try {
      result = proceedingJoinPoint.proceed();
    } catch (Exception ex) {
      System.out.println(STR."AROUND The message error is: \{ex.getMessage()}");
      throw ex;
    }
    System.out.println("result = " + result);

    System.out.println("---tareas después de llamada---");
    Instant endTime = Instant.now();
    System.out.println(STR."Duración de la ejecución del método: \{ Duration.between(beginTime, endTime).toMillis() } milliseconds");
    return result;
  }

}
