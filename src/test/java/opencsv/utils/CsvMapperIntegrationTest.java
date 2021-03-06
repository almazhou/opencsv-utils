package opencsv.utils;

import org.junit.Test;

import java.io.StringReader;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CsvMapperIntegrationTest {
    @Test
    public void shouldGetPersonFromCsv() throws Exception {
        StringReader reader = new StringReader("id,person name\n1,name1\n2,name2\n");
        List<Person> personList = new CsvMapper<Person>(Person.class)
                .withMapping(new CsvColumnMapping(Person.class))
                .fromCsv(reader);

        assertThat(personList.size(), is(2));

        final Person first = personList.get(0);
        assertThat(first.getId(), is(1));
        assertThat(first.getName(), is("name1"));

        final Person second = personList.get(1);
        assertThat(second.getId(), is(2));
        assertThat(second.getName(), is("name2"));

    }
}
