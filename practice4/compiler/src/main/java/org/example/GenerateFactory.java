package org.example;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.util.Map;

public class GenerateFactory {
    private Filer filer;
    private Map<String, ClassName> input;

    public GenerateFactory(Filer filer, Map<String, ClassName> input) {
        this.filer = filer;
        this.input = input;
    }

    void generate() throws IOException {
        for (String key : input.keySet()) {
            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("helloFrom" + input.get(key).simpleName())
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .addStatement("System.out.println(\"Hello.\")");

            MethodSpec methodSpec = methodBuilder.build();
            TypeSpec helloWorld = TypeSpec.classBuilder(input.get(key).simpleName() + "Generate")
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addMethod(methodSpec)
                    .build();
            JavaFile javaFile = JavaFile.builder(input.get(key).packageName(), helloWorld)
                    .build();

            javaFile.writeTo(filer);
        }
    }
}
