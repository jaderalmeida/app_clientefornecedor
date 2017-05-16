using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace PedidosLojista.Models
{
    public class Pedido : ContentPage
    {
        public string Codigo { get; set; }
        public string Nome { get; set; }

        public string Item { get; set; }
        public decimal Preco { get; set; }
        public string PrecoFormatado
        {
            get { return string.Format("R$ {0}", Preco); }
        }
    }
}

