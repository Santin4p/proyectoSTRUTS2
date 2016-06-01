package persistencia;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //La anotacion se usará en tiempo de ejecución
@Target(ElementType.FIELD)			//La anotacion se aplicará a un campo de una clase
public @interface Identificador {
}
