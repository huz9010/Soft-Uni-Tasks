package military_elite;

public enum Corps {

    Airforces,
    Marines;

    public boolean contains(String test)    {
        for (Corps c : values())    {
            if (c.name().equals(test))  {
                return true;
            }
        }
        return false;
    }
}
