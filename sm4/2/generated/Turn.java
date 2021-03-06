/*
 * generated by Fujaba - CodeGen2
 */
import de.uni_kassel.features.annotation.util.Property; // requires Fujaba5/libs/features.jar in classpath
import de.uni_kassel.features.ReferenceHandler; // requires Fujaba5/libs/features.jar in classpath


public abstract class Turn
{



   private  Turn ()
   {
   }

   public static final String PROPERTY_CARD = "card";

   @Property( name = PROPERTY_CARD, kind = ReferenceHandler.ReferenceKind.ATTRIBUTE )
   private Card card;

   @Property( name = PROPERTY_CARD )
   public void setCard (Card value)
   {
      this.card = value;
   }

   public Turn withCard (Card value)
   {
      setCard (value);
      return this;
   }

   @Property( name = PROPERTY_CARD )
   public Card getCard ()
   {
      return this.card;
   }

   public static Turn getInstance ()
   {
   }

   public void playCard ()
   {
   }

   /**
    * <pre>
    *           1     happens     1
    * Turn ------------------------- playCard
    *           turn               playCard
    * </pre>
    */
   public static final String PROPERTY_PLAY_CARD = "playCard";

   @Property( name = PROPERTY_PLAY_CARD, partner = playCard.PROPERTY_TURN, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private playCard playCard;

   @Property( name = PROPERTY_PLAY_CARD )
   public boolean setPlayCard (playCard value)
   {
      boolean changed = false;

      if (this.playCard != value)
      {
      
         playCard oldValue = this.playCard;
         Turn source = this;
         if (this.playCard != null)
         {
            this.playCard = null;
            oldValue.setTurn (null);
         }
         this.playCard = value;

         if (value != null)
         {
            value.setTurn (this);
         }
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_PLAY_CARD )
   public Turn withPlayCard (playCard value)
   {
      setPlayCard (value);
      return this;
   }

   public playCard getPlayCard ()
   {
      return this.playCard;
   }

   /**
    * <pre>
    *           1     has     1
    * Turn ------------------------- Player
    *           turn               player
    * </pre>
    */
   public static final String PROPERTY_PLAYER = "player";

   @Property( name = PROPERTY_PLAYER, partner = Player.PROPERTY_TURN, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Player player;

   @Property( name = PROPERTY_PLAYER )
   public boolean setPlayer (Player value)
   {
      boolean changed = false;

      if (this.player != value)
      {
      
         Player oldValue = this.player;
         Turn source = this;
         if (this.player != null)
         {
            this.player = null;
            oldValue.setTurn (null);
         }
         this.player = value;

         if (value != null)
         {
            value.setTurn (this);
         }
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_PLAYER )
   public Turn withPlayer (Player value)
   {
      setPlayer (value);
      return this;
   }

   public Player getPlayer ()
   {
      return this.player;
   }

   public static final String PROPERTY_STRATEGY = "strategy";

   @Property( name = PROPERTY_STRATEGY, kind = ReferenceHandler.ReferenceKind.ATTRIBUTE )
   private playCard strategy;

   @Property( name = PROPERTY_STRATEGY )
   public void setStrategy (playCard value)
   {
      this.strategy = value;
   }

   public Turn withStrategy (playCard value)
   {
      setStrategy (value);
      return this;
   }

   @Property( name = PROPERTY_STRATEGY )
   public playCard getStrategy ()
   {
      return this.strategy;
   }

   public static final String PROPERTY_SUIT = "suit";

   @Property( name = PROPERTY_SUIT, kind = ReferenceHandler.ReferenceKind.ATTRIBUTE )
   private String suit;

   @Property( name = PROPERTY_SUIT )
   public void setSuit (String value)
   {
      this.suit = value;
   }

   public Turn withSuit (String value)
   {
      setSuit (value);
      return this;
   }

   @Property( name = PROPERTY_SUIT )
   public String getSuit ()
   {
      return this.suit;
   }

   public static final String PROPERTY_TURN = "turn";

   @Property( name = PROPERTY_TURN, kind = ReferenceHandler.ReferenceKind.ATTRIBUTE )
   private static Turn turn = new Turn();


   public static final String PROPERTY_VALUE = "value";

   @Property( name = PROPERTY_VALUE, kind = ReferenceHandler.ReferenceKind.ATTRIBUTE )
   private String value;

   @Property( name = PROPERTY_VALUE )
   public void setValue (String value)
   {
      this.value = value;
   }

   public Turn withValue (String value)
   {
      setValue (value);
      return this;
   }

   @Property( name = PROPERTY_VALUE )
   public String getValue ()
   {
      return this.value;
   }

   public void removeYou()
   {
      this.setPlayCard (null);
      this.setPlayer (null);
   }
}


