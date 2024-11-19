package com.example.blytur.view;

import com.example.blytur.chat.ChatService;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;

@Component
public class ChatView extends VerticalLayout {

    private final ChatService chatService;
    private final MessageList messageList = new MessageList();
    private final MessageInput messageInput = new MessageInput();

    public ChatView(ChatService chatService) {
        this.chatService = chatService;

        // Exibe a mensagem inicial do assistente
        addMessage("Olá, como posso ajudar?", "Blytúr", true);

        // Configura a interface
        messageList.setWidthFull();
        messageList.setHeightFull();
        messageInput.setWidthFull();

        setHeightFull();
        setWidthFull();

        // Quando a mensagem é enviada, chama o método send
        messageInput.addSubmitListener(event -> send(event.getValue()));

        add(messageList, messageInput);
    }

    private void send(String message) {
        // Exibe a mensagem do usuário
        addMessage(message, "Você", false);

        // Chama o serviço para obter a resposta da IA
        var response = chatService.sendToAi(message);
        
        // Exibe a resposta do assistente
        addMessage(response, "Blytúr", true);
    }

    private void addMessage(String message, String username, boolean isChatAssistent) {
        // Cria um item de mensagem
        var messageItem = new MessageListItem(
                message,
                Instant.now(),
                username,
                isChatAssistent ? 
                    "https://avatar.iran.liara.run/public/job/operator/male" : 
                    "https://avatar.iran.liara.run/public/job/doctor/male"
        );

        // Adiciona a nova mensagem à lista
        var messages = new ArrayList<>(messageList.getItems());
        messages.add(messageItem);
        messageList.setItems(messages);
    }
}
