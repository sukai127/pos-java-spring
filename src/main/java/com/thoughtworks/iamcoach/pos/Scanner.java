package com.thoughtworks.iamcoach.pos;

import java.util.*;

public interface Scanner {
    public List scan(List<String> barcodes) throws Exception;
}
