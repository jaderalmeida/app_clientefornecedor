using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using PedidosLojista.Models;
using PedidosLojista.ViewModels;
using Xamarin.Forms;
using System.Diagnostics.Contracts;

namespace PedidosLojista.ViewModels
{
    public class ListagemViewModel : BaseViewModel
    {

        const string URL_GET_PEDIDOS = "URL/";


        public ObservableCollection<Pedido> Pedidos { get; set; }

		Pedido pedidoSelecionado;
		public Pedido PedidoSelecionado
		{
			get
			{
				return pedidoSelecionado;
			}
			set
			{
				pedidoSelecionado = value;
				if (value != null)
					MessagingCenter.Send(pedidoSelecionado, "PedidoSelecionado");
			}
		}

		private bool aguarde;
        public bool Aguarde
        {
            get { return aguarde; }
            set
            {
                aguarde = value;
                OnPropertyChanged();
            }
        }


        public ListagemViewModel()
        {
            //this.Veiculos = new ObservableCollection<Veiculo>();

            this.Pedidos = new ObservableCollection<Pedido>();
        }


		public async Task GetPedidos()
		{
            Contract.Ensures(Contract.Result<Task>() != null);
            Aguarde = true;
			try
			{
				HttpClient cliente = new HttpClient();

				var resultado = await cliente.GetStringAsync(URL_GET_PEDIDOS);

				var pedidosJson = JsonConvert.DeserializeObject<PedidoJson[]>(resultado);

				foreach (var pedidoJson in pedidosJson)
				{
					this.Pedidos.Add(new Pedido
					{
                        Codigo = pedidoJson.codigo,
						Nome = pedidoJson.nome,
						Preco = pedidoJson.preco,
                        Item = pedidoJson.item
					});
				}
			}
			catch (Exception exc)
			{
				MessagingCenter.Send<Exception>(exc, "FalhaListagem");
			}
			Aguarde = false;
		}
    }

   
	class PedidoJson
	{
        public string codigo { get; set; }
		public string nome { get; set; }
        public int preco { get; set; }
		public string item { get; set; }
	}
}
