import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Predicates.contains;
import static com.google.common.base.Predicates.containsPattern;
import static com.google.common.base.Predicates.or;
import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Ordering.natural;
import static java.lang.System.out;
import static java.util.Arrays.asList;
import static java.util.regex.Pattern.compile;

public class GuavaDemo {
  public static void main(String[] args) {
    List<String> list = asList("a1", "b2", "c3");
    out.println(
        filter(list, Predicates.or(Predicates.containsPattern("b"), Predicates.containsPattern("3")))
    );

    out.println(filter(list, new Predicate<String>() {
      @Override public boolean apply(String s) {
        return s.startsWith("b");
      }
    }));

    out.println(from(list).filter(new Predicate<String>() {
      @Override public boolean apply(String s) {
        return s.startsWith("a");
      }
    }).limit(5).toSortedList(natural().reverse()));
  }
}
