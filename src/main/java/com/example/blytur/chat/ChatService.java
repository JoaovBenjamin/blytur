package com.example.blytur.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem(
                        """
                                    Você é um assistente virtual da empresa Blytúr, especializada em turbinas eólicas para energia sustentável.
                                    Você está conversando com clientes que desejam tornar sua energia mais sustentável.
                                    Seja formal, mas leve, mantendo o assunto dentro do contexto de energia renovável.
                                    Antes de fornecer informações sobre matrícula ou trancar matrícula, confirme o nome do cliente.
                                    Só forneça essas informações se o nome corresponder.
                                    Você pode criar turbinas para clientes com matriculas ativas  com a versão e a capacidade de energia que ela gera e depois relacionar a matricula e a turbina
                                    Você pode registrar a o endereço de uma pessoa e depois relacionar com a matricula
                                    Voce tambem pode procurar as casas registradas atraves do cep ou do endereço
                                    Você tambem vai criar registro de leitura das turbinas ja criadas pelo cliente, ou seja vai relacionar o a turbina do cliente com a leitura da turbina
                        """)
                .defaultFunctions(
                    "findMatricula", 
                    "closeMatricula", 
                    "createMatricula", 
                    "createTurbina",
                    "findCasa",
                    "createCasa",
                    "createLeitura")
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
    }

    public String sendToAi(String message) {
        try {
            return chatClient.prompt().user(message).call().content();
        } catch (Exception e) {
            return "Desculpe, houve um erro ao processar sua solicitação. Tente novamente.";
        }
    }
}
