package com.lekmiti.customannotations;

import java.io.IOException;

public interface Serializer {
    public String serialize(Object object) throws JsonSerializeException, IOException;
}
