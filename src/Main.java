import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import commands.Command;
import commands.CommandError;
import commands.ExecuteScript;
import commands.Exit;
import message.Message;
import organization.Address;
import organization.Organization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO:
//        String filename = System.getenv("filename");
        if (args.length != 1) {
            System.out.println("Введите название файла в командную строку!");
            System.exit(-1);
        }

        String filename = args[0];
        if (filename == null) {
            System.out.println("Не задано имя файла");
            System.exit(-1);
        }

        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("Файл не существует");
            System.exit(-1);
        }

        try {
            System.out.println(file.toPath().toRealPath());
            String string = file.toPath().toRealPath().toString();
            if (string.matches("/*/dev.*")) {
                System.out.println("Файл не подходит");
                System.exit(-1);
            }
        } catch (IOException e){
            System.out.println("Хватит");
            System.exit(-1);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        FileWorker fileWorker = new FileWorker(file, objectMapper);
        CollectionWorkerImpl scw = new CollectionWorkerImpl(fileWorker);

        try {
            Scanner scan = new Scanner(System.in);
            CommandListener commandListener = new CommandListener(System.in, false);
            do {
                System.out.println("Введите комманду.");
                System.out.print("> ");
                Command cmd = commandListener.readCommand();
                if (cmd instanceof Exit) {
                    scan.close();
                    System.out.println("Завершение работы.");
                    System.exit(0);
                } else {
                    if (cmd instanceof ExecuteScript) {
                        for (Command c : ((ExecuteScript) cmd).getCommands()) {
                            if (c instanceof CommandError) {
                                System.out.println(scw.execute(c).getContent());
                                break;
                            }
                            Message msg = scw.execute(c);
                            System.out.println(msg.getContent());
                        }
                    } else {
                        Message msg = scw.execute(cmd);
                        System.out.println(msg.getContent());
                    }
                }
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}