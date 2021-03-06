package com.cs509.handlers;

import com.amazonaws.util.json.Jackson;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class testDeleteCardHandler {
    @Test
    public void test() throws IOException {
        JsonObject data  = new JsonObject();
        int cadID = 999;
        data.addProperty("cadID", cadID);

        DeleteCardHandler Handler = new DeleteCardHandler();
        String str = data.toString();

        InputStream input = new ByteArrayInputStream(str.getBytes());
        OutputStream output = new ByteArrayOutputStream();
        testContext ctx = new testContext();

        Handler.handleRequest(input, output, ctx);
        JsonNode outputNode = Jackson.fromJsonString(output.toString(), JsonNode.class);
        String code  = outputNode.get("statusCode").asText();
        Assert.assertEquals("200", code);

    }
}
