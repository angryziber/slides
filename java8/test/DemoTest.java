import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class DemoTest {
  @Test
  public void hello() throws Exception {
    assertThat("somehting", not(equalTo("nothing")));
  }
}
