package game;

import java.util.Scanner;

/**
 * A tile-based game with the goal of activating each tile by lighting them up.
 * 
 * @author Group 13
 * @version 12 Oct 2026
 */
public class Main
{
    /**
     * four direction variables to work between classes and improve readability.
     * 
     * @author Chris
     * @version 12 Oct 2026
     */
    public static enum direction
    {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    /**
     * Main game loop and logic.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        Map map = new Map();
        Player player = new Player();

        try
        {
            map.importMap("map.txt");
        }
        catch (Exception e)
        {
            System.out.println("Map import failed, shutting down.");
            return;
        }

        System.out.print(map);

        while (!map.hasWon())
        {
            String input = validateInput();

            switch (input)
            {
                case "quit":
                    System.out.println("quitting...");
                    return;
                case "x":
                    player.undoMove();
                    map.undoMove();
                    break;
                default:
                    direction dir = direction.UP; // figure out how to map
                                                  // strings to enum

                    if (map.canMove(player.getPosition(), dir))
                    {
                        // TODO
                    }
                    else
                    {
                        // TODO
                    }
            }

            System.out.print(map);
        }

        // win TODO

        return;
    }


    /**
     * Repeatedly takes user input to run game commands.
     * 
     * @return one of six valid commands (directions, undo, quit)
     */
    public static String validateInput()
    {
        String[] validCommands = {"w", "a", "s", "d", "x", "quit"};
        String command = "";
        Scanner input = new Scanner(System.in);

        System.out.print("Input a command: ");
        
        while (true)
        {
            command = input.nextLine().toLowerCase();

            for (String validCommand : validCommands) {
                if (command.equals(validCommand)) {
                    input.close();
                    
                    return command;
                }
            }
            
            
            System.out.println("Invalid command, try again: ")
        }
    }
}
