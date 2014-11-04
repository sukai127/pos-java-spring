package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.utils.FileUtils;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileUtilsTest {
    @Test
    public void getTest() throws IOException {

        List list = FileUtils.get("cart.txt");
        assertThat(list.size()).isEqualTo(14);
    }

    @Test
    public void should_return_pos_when_input_key() throws Exception{

        String value = FileUtils.getValue("user");
        assertThat(value).isEqualTo("pos");

    }
}
