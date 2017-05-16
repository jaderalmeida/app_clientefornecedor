using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PedidosLojista.Models;
using PedidosLojista.ViewModels;
using Xamarin.Forms;


namespace PedidosLojista.Views
{
    public partial class DetalhePedidosView : ContentPage
    {
        public ListagemViewModel ViewModel { get; set; }


		public DetalhePedidosView(Pedido pedido)
		{
			InitializeComponent();
			this.ViewModel = new ListagemViewModel();
			this.BindingContext = this.ViewModel;
		}


		protected async override void OnAppearing()
		{
			base.OnAppearing();


			MessagingCenter.Subscribe<Pedido>(this, "PedidoSelecionado",
				(msg) =>
				{
					//Navigation.PushAsync(new DetalheView(msg));
					//Navigation.PushAsync(new DetalhePedidosView(msg));
				});

			MessagingCenter.Subscribe<Exception>(this, "FalhaListagem",
				(msg) =>
				{
					DisplayAlert("Erro", "Ocorreu um ao carregar pedidos, por favor tente novamente mais tarde.", "Ok");
				});

			await this.ViewModel.GetPedidos();

		}

    }
}
