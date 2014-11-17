import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.matcher.Matchers;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.MethodAccessor_Integer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class GuiceDemo {
  @Retention(RUNTIME)
  public @interface Cache {}

  public static void main(String[] args) {
    class X extends AbstractModule {
      @Override
      protected void configure() {
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Cache.class));
      }
    }

    Injector injector = Guice.createInjector(new X());
    GuiceDemo demo = injector.getProvider(GuiceDemo.class).get();
    System.out.println(demo);
  }
}
