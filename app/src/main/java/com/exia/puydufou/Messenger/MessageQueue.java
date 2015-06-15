package com.exia.puydufou.Messenger;


import java.util.Stack;

public class MessageQueue
{
    //SubClass
    private final class StackObject<T>
    {
        private Class<T> _type = null;
        private T _object = null;

        public StackObject(T object, Class type)
        {
            _type = type;
            _object = object;
        }

        public Class<T> GetType()
        {
            return _type;
        }
        public void SetType(Class<T> type)
        {
            _type = type;
        }

        public T GetObject()
        {
            return _object;
        }
        public void SetObject(T object)
        {
            _object = object;
        }
    }

    private MessageQueue()
    {
        _stack = new Stack<StackObject>();
    }

    /** Holder */
    private static class MessageHolder
    {
        /** Instance unique non préinitialisée */
        private final static MessageQueue instance = new MessageQueue();
    }

    /** Point d'accès pour l'instance unique du singleton */
    public static MessageQueue Instance()
    {
        return MessageHolder.instance;
    }

    //FIELDS
    private Stack<StackObject> _stack = null;


    //METHODS
    public <T> void AddMessage(T message)
    {
        _stack.push(new StackObject<T>(message, message.getClass()));
    }

    public <T> T RetrievingLastMessage(Class<T> type)
    {
        for (int i = _stack.size() - 1; i >= 0; i--)
        {
            if(_stack.elementAt(i).GetType() == type)
            {
                T temp = (T)_stack.elementAt(i)._object;
                _stack.remove(i);
                return temp;
            }
        }

        return null;
    }

}
