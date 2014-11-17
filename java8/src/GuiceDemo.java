import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.google.inject.matcher.Matchers.annotatedWith;
import static com.google.inject.matcher.Matchers.any;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class GuiceDemo {
  @Retention(RUNTIME)
  public @interface Cache {}

  public static void main(String[] args) {
    class X extends AbstractModule {
      @Override
      protected void configure() {
        bindInterceptor(any(), annotatedWith(Cache.class), invocation -> null);
      }
    }

    Injector injector = Guice.createInjector(new X());
    GuiceDemo demo = injector.getProvider(GuiceDemo.class).get();
    System.out.println(demo);
  }
}
