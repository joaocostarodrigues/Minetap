package argo.jdom;

public final class JsonNodeSelector
{
    final Functor valueGetter;

    JsonNodeSelector(Functor par1Functor)
    {
        this.valueGetter = par1Functor;
    }

    


    public boolean matches(Object par1Obj)
    {
        return this.valueGetter.matchesNode(par1Obj);
    }

    public Object getValue(Object par1Obj)
    {
        return this.valueGetter.applyTo(par1Obj);
    }

    





    public JsonNodeSelector with(JsonNodeSelector par1JsonNodeSelector)
    {
        return new JsonNodeSelector(new ChainedFunctor(this, par1JsonNodeSelector));
    }

    String shortForm()
    {
        return this.valueGetter.shortForm();
    }

    public String toString()
    {
        return this.valueGetter.toString();
    }
}
