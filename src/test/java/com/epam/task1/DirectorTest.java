package com.epam.task1;

import com.epam.task1.exceptions.DataException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doThrow;

public class DirectorTest {

    @Test(expected = DataException.class)
    public void testReadShouldThrowDataExceptionWhenPathIncorrect() throws IOException {
        // given
        Director director = Mockito.mock(Director.class);

        // when
        Mockito.when(director.read("invalidFileName"))
                .thenThrow(DataException.class);

        // then
        director.read("invalidFileName");
    }

    @Test
    public void testReadShouldReadWhenlineCorrect() throws IOException {
        // given
        Director director = Mockito.mock(Director.class);
        List<Sphere> spheres = new ArrayList<>();
        spheres.add(new Sphere(new Point3D(1, 2, 3), 4));
        spheres.add(new Sphere(new Point3D(1, 2, 3), 4));

        // when
        Mockito.when(director.read("correctFileName")).thenReturn(spheres);

        // then
    }
}
