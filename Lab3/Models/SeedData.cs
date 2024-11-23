using Microsoft.EntityFrameworkCore;

namespace Lab3.Models
{
    public static class SeedData
    {
        public static void SeedDatabase(DataContext context)
        {
            context.Database.Migrate();
            if (context.Products.Count() == 0&&
                context.Suppliers.Count()==0&&
                context.Categories.Count()==0)
            {
                Supplier s1 = new Supplier { Name = "Дудка компани", City = "Дудка сити" };
                Supplier s2 = new Supplier { Name = "Идриутка", City = "Дудка вилладж" };
                Supplier s3 = new Supplier { Name = "Хомячков корпорейтед", City = "Дудка бомж" };

                Category c1 = new Category { Name = "Хлебо-уточная" };
                Category c2 = new Category { Name = "Молочная" };
                Category c3 = new Category { Name = "Канцелярия" };

                c
            }
        }
    }
}
