# Projet_L3_S6


#Les gars, on déchire tout !
#On a le moteur qui marche, il ne reste qu'à faire les IA et finir l'IHM !
#On est largement dans les temps, et c'est génial.
#Continuons comme ça !

interface Player
  Coordonate play(Grid grid);
  
  class IA
  class RealLifePlayer

interface Game
   class WaffleGame
      Grid grid;
      Player[2] players;
      
      public :
        void cancel();
        void redo();
        void save();
        void load();
        void play();
      
      private :
        bool winCheck();
      
    class Grid
      final int width;
      final int height;
      Case[][] grid;
      
      public :
        int getWidth();
        int getHeight();
        State getStateAtCase(Coordonate c);
        void setStateAtCase(Coordonate c, State);
        String toString();
        void load(String textGrid);
      
    class Case
      State state;
      public:
        State getState();
        void setState(State);
    
    Enum State;
    
    Class Coordonate
      final int x;
      final int y;
      public :
        getX();
        getY();

interface IHM
