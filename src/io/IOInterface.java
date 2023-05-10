package io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IOInterface<E> {
void write(List<E> e, String path);
ArrayList<E> read(String path) throws IOException;
}
