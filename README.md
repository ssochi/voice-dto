## Why Models

Models supports base usage of dto ,and it supports more Scalable function 
such like toJson ,toString ,map ,and most important ,Models is Multiple Inheritance.All of those function can make your own Models
more useful .

### First

you should create a simple interface (or called it model)

```code
    @Model
    public interface task1{
        public void setName(String name);
        public String getName();
    }

```

#### then using modelfactory create it 

```code
    task1 task1 = ModelFactory.create(task1.class);
    task1.setName("task1");
    System.out.println(task1.getName());
```

#### want have a toString function ?

```code
    @Model
        public interface task1{
            public void setName(String name);
            public String getName();
            @DtoListener(DtoListener = ToStringListener.class)
            public String toString();
        }
```
model now have four default functions :
clear,toJson,jsonFrom,map.and all those function are proxyListener ,
and there is a interface called Utils ,you can make your models extends Utils,and your
models can have all the function above.

#### annotations
```code
    @Model
    describe the model ,if you need using default json operations ,
    you should add this annotation in your model-interface .
    
    @DtoListener
    if you want make your models support some function ,you should
    add this annotation to listen your function .
    
    @DtoFilter
    this is a method filter ,you can add it to every method you 
    wanna filte .
    
```

