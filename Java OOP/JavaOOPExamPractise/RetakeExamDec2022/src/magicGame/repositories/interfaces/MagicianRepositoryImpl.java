package magicGame.repositories.interfaces;

import magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static magicGame.common.ExceptionMessages.*;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {

    List<Magician> data;

    public MagicianRepositoryImpl() {
        data = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return this.data;
    }

    @Override
    public void addMagician(Magician model) {
        if (model == null)  {
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        if (data.contains(model))   {
            data.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Magician findByUsername(String name) {
        for (Magician magician : data)  {
            if (magician.getUsername().equals(name))    {
                return magician;
            }
        }
        return null;
    }
}
