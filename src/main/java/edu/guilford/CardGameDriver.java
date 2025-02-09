package edu.guilford;

public class CardGameDriver {
    public static void main(String[] args) {
        // Runs the Blackjack game 10000 times
        final int NGAMES = 10000;
        int dealerWins = 0;
        int playerWins = 0;
        Blackjack game = new Blackjack();
        game.deal();
        // System.out.println(game);
        int iGame = 0;
        while (iGame < NGAMES) {
            game.deal();
            if (game.getPlayerHand().getTotalValue() == 21) {
                playerWins++;
            } else if (game.getDealerHand().getTotalValue() == 21) {
                dealerWins++;
            } else {
                boolean playerResult = game.playerTurn();
                boolean dealerResult = game.dealerTurn();
                if (!playerResult) {
                    dealerWins++;
                } else if (!dealerResult) {
                    playerWins++;
                } else if (game.getPlayerHand().getTotalValue() < game.getDealerHand().getTotalValue()) {
                    dealerWins++;
                } else if (game.getPlayerHand().getTotalValue() > game.getDealerHand().getTotalValue()) {
                    playerWins++;
                }
            }
            if (game.getDeck().size() < 10) {
                game.reset();
            }

            iGame++;
        }

        // Prints the results of the Blackjack game
        System.out.println("Dealer wins: " + dealerWins);
        System.out.println("Player wins: " + playerWins);
        System.out.println("Pushes: " + (NGAMES - dealerWins - playerWins));

        // Runs the Lamarckian Poker game
        LamarckianPoker lmpGame = new LamarckianPoker();
        lmpGame.deal();
        System.out.println("\nInitial Lamarckian hands\n" + lmpGame);

        boolean gameDone = false;
        while (!gameDone) {
        //    System.out.println(lmpGame);
            gameDone = !lmpGame.turn();
        }

        // Prints the results of the Lamarckian Poker game
  
        System.out.println("Final Lamarckian hands\n" + lmpGame); 
        System.out.println( lmpGame.getWinner()+ " wins the Lamarckian Poker game."); 
        
        //Running the Lamarckian Poker game 10000 times
        int player1Wins = 0;
        int player2Wins = 0;
        int ties = 0;
        for (int i = 0; i < 10000; i++) {
            LamarckianPoker game1 = new LamarckianPoker();
            game1.deal();
            gameDone = false;
            while (!gameDone) {
                gameDone = !game1.turn();
            }
            if (game1.getWinner().equals("Player 1")) {
                player1Wins++;
            } else if (game1.getWinner().equals("Player 2")) {
                player2Wins++;
            } else {
                ties++;
            }
        }
        // Prints the results of the Lamarckian Poker game
        System.out.println("Player 1 wins: " + player1Wins);
        System.out.println("Player 2 wins: " + player2Wins);
        System.out.println("Ties: " + ties);

    }
}