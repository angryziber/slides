import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Predicates.contains;
import static com.google.common.base.Predicates.containsPattern;
import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Iterables.filter;
import static java.lang.System.out;
import static java.util.Arrays.asList;
import static java.util.regex.Pattern.compile;

public class GuavaDemo {
  public static void main(String[] args) {
    List<String> list = asList("a1", "b2", "c3");
    out.println(
        Iterables.filter(list, Predicates.or(Predicates.containsPattern("b"), Predicates.containsPattern("3")))
    );
  }
}
