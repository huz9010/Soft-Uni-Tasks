package magicGame.repositories.interfaces;

import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static magicGame.common.ExceptionMessages.*;

public class MagicRepositoryImpl implements MagicRepository<Magic> {

    private List<Magic> data;

    public MagicRepositoryImpl() {
        data = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return this.data;
    }

    @Override
    public void addMagic(Magic model) {
        if (model == null)  {
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        if (data.contains(model))   {
            data.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Magic findByName(String name) {
        for (Magic magic : data)    {
            if (magic.getName().equals(name))   {
                return magic;
            }
        }
        return null;
    }
}
