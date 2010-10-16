/*
 * generated by Fujaba - CodeGen2
 */
import de.uni_kassel.features.annotation.util.Property; // requires Fujaba5/libs/features.jar in classpath
import de.uni_kassel.features.ReferenceHandler; // requires Fujaba5/libs/features.jar in classpath


public class SearchVisitor extends Visitor
{



   public static final String PROPERTY_SEARCH_PATTERN = "searchPattern";

   @Property( name = PROPERTY_SEARCH_PATTERN, kind = ReferenceHandler.ReferenceKind.ATTRIBUTE )
   private String searchPattern;

   @Property( name = PROPERTY_SEARCH_PATTERN )
   public void setSearchPattern (String value)
   {
      this.searchPattern = value;
   }

   public SearchVisitor withSearchPattern (String value)
   {
      setSearchPattern (value);
      return this;
   }

   @Property( name = PROPERTY_SEARCH_PATTERN )
   public String getSearchPattern ()
   {
      return this.searchPattern;
   }

   public void visit (AbstractDirectory directory )
   {
   }

   public void visit (AbstractFile file )
   {
   }

}


