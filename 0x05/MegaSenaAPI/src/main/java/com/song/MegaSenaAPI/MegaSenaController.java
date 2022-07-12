package com.song.MegaSenaAPI;

import com.song.MegaSenaAPI.util.RandomNumbersUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Bem vindo a API REST para geração de números para a loteria Mega Sena.";
    }

    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        return RandomNumbersUtil.getListOfRandomNumbers();
    }
}
