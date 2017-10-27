#include<iostream>
#include<stdlib.h>
#include<cstring>
using namespace std;

struct M
{
	char name;
	int row;
    int col;
	M* next;
};

int calculate(char f[100]);
void show(M* p);
M* getMatrix(char name);


M* mHead = NULL;
M* iterator_m = NULL;
M* stack_top = NULL;

void push(M* item)
{
    if(stack_top == NULL)
        stack_top = item;
    else
    {
        item->next = stack_top;
        stack_top = item;
    }
}
M* pop()
{
    if(stack_top != NULL)
    {
        M* goal = stack_top;
        stack_top = stack_top->next;
        return goal;
    }
    return NULL;
}

int main()
{

    int n ;
    cin >> n;
    for(int i=0;i<n;i++)
    {
        M* m = new M;
        m->next = NULL;
        cin >> m->name >> m->row >> m->col;

        if(mHead == NULL)
        {
            mHead = m;
        }else
        {
            iterator_m = mHead;

            while(iterator_m->next != NULL)
                iterator_m = iterator_m->next;

            iterator_m->next = m;
        }
    }

    while(!cin.eof())
    {
        char func[50] ={'\0'};
        cin >> func;
        int mutipleTimes = calculate(func);
        if(mutipleTimes<0)
            cout << "error"<<endl;
        else
            cout << mutipleTimes <<endl;
    }

	return 0;
}

void show(M* p)
{
    iterator_m  = p;

    while(iterator_m != NULL)
    {
        cout << iterator_m->name << ":" << iterator_m->row<< "x" << iterator_m->col<<endl<<endl;
        iterator_m = iterator_m->next;
    }
}


M* getMatrix(char name)
{
    iterator_m = mHead;

    while(iterator_m != NULL)
    {
        if(iterator_m->name == name)
            return iterator_m;
        iterator_m = iterator_m->next;
    }
}

int calculate(char f[50])
{
    if(strlen(f)== 1)
        return 0;

    int sum = 0;

     M* m1;
     M* m2;

    for(int i=0;i<strlen(f);i++)
    {
        M* item = new M;;

        if(f[i] == '(')
        {
            item->name = '(';
            item->row = 0;
            item->col = 0;
            push(item);
        }else if(f[i] == ')')
        {
            m2 = pop();
            m1 = pop();
            pop();

            if(m1->col != m2->row)
                return -1;

            sum += (m1->row*m1->col*m2->col);
            item->name = '!';
            item->row = m1->row;
            item->col = m2->col;
            item->next = NULL;
            push(item);
        }else
        {
            item->name = getMatrix(f[i])->name;
            item->row = getMatrix(f[i])->row;
            item->col = getMatrix(f[i])->col;
            item->next = NULL;
            push(item);
        }

    }
    return sum;
}
