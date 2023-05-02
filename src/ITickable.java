public interface ITickable{
    public default void Tick(){
        System.out.println("Tick, I'm a clock");
    }
}
