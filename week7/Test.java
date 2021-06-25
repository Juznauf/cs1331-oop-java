// abstract static class Person {
abstract class Person {
    public String name;
    public Person(String name) { this.name = name; }
    public Object covariantReturn() { return new Object(); }
}
// static class LostPerson extends Person {
class LostPerson extends Person {
    public LostPerson(String name) { super(name); }
    @Override public LostPerson covariantReturn(){return this;}
}
// static class SubLostPerson extends LostPerson {
class SubLostPerson extends LostPerson {
    public SubLostPerson(String name) { super(name); }
    // @Override public Person covariantReturn() {return this;} // as Person is not a subtype of LostPerson, will not compile
    @Override public SubLostPerson covariantReturn() {return this;}
}
