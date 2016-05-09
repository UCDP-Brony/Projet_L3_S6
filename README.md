# Projet_L3_S6

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
      Case[][] grid;
      
      public :
        State getStateAtCase(Coordonate c);
        void setStateAtCase(Coordonate c, State);
      
    class Case
      State state;
      public:
        State getState();
        void setState();
    
    Enum State;
    
    Class Coordonate
      int x;
      int y;
      public :
        getX();
        getY();

interface IHM
