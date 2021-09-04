import java.util.ArrayList;

 // "Subject"
 abstract class Book {
    // Fields
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    // Methods
    public void attach(Observer observer) {
       observers.add(observer);
    }
    public void detach(Observer observer) {
       observers.remove(observer);
    }
    public void notifyObservers() {
       for (Observer o : observers)    
          o.update();
   }
 }
 // "ConcreteSubject"
 class ConcreteBook extends Book {
  // Fields
  private String bookState;
  // Properties
  public String getBookState() {
    return bookState;
  }
  public void setBookState(String value) {
    bookState = value;
  }
 }
 // "Observer"
 abstract class Observer {
   // Methods
   abstract public void update();
 }
 // "ConcreteObserver"
 class ConcreteObserver extends Observer {
  // Fields
  private String name;
  private String observerState;
  private ConcreteBook book;
 
  // Constructors
  public ConcreteObserver(ConcreteBook book, String name) {
     this.book = book;
     this.name = name;
     //subject.attach(this);
  }
  // Methods
  public void update() {
     observerState = book.getBookState();
     System.out.printf("Observer %s's new state is %s\n", name, observerState);
  }
 }
 // Client test
 public class Client {
   public static void main(String[] args) {
      // Configure Observer structure
      ConcreteBook s = new ConcreteBook();
      s.attach(new ConcreteObserver(s, "c"));
      s.attach(new ConcreteObserver(s, "z"));
      s.attach(new ConcreteObserver(s, "m"));

      // Change subject and notify observers
      s.setBookState("taken");
      s.notifyObservers();
   }
 }
