using System.Numerics;

namespace ArrayHomework
{
    internal class Program
    {
        static void Main(string[] args)
        {

            int[] numbers = new int[10];
            
            Console.WriteLine("Welcome to my array homework.");
            Console.WriteLine("For this homework we'll be working with an array of numbers, so I'll need your help entering 10 digits.");
            
                for (int i = 0; i < numbers.Length; i++)
                {
                    Console.WriteLine("Please enter a number: ");
                    numbers[i] = Convert.ToInt32(Console.ReadLine());
                     
                }
            

            numbers = numbers.OrderBy(x => x).ToArray();

            Console.WriteLine("Here are the numbers sorthed");

            foreach ( var number in numbers)
            {
                Console.WriteLine(number);
            }

        }
    }
}
