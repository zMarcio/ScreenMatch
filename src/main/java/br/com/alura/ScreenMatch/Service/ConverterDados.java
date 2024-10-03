package br.com.alura.ScreenMatch.Service;

public interface ConverterDados {
    <T> T obterDados(String json, Class<T> classe);
}
